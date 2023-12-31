package com.trybe.simuladordepix;

import java.io.IOException;

/**
 * author joao.
 *
 */
public class ProcessadorDePix {

  private final Servidor servidor;

  public ProcessadorDePix(Servidor servidor) {
    this.servidor = servidor;
  }

  /**
   * Executa a operação do pix. Aqui é implementada a lógica de negócio sem envolver as interações
   * do aplicativo com a pessoa usuária.
   *
   * @param valor Valor em centavos a ser transferido.
   * @param chave Chave Pix do beneficiário da transação.
   *
   * @throws ErroDePix Erro de aplicação, caso ocorra qualquer inconformidade.
   * @throws IOException Caso aconteça algum problema relacionado à comunicação entre o aplicativo e
   *         o servidor na nuvem.
   */
  public void executarPix(int valor, String chave) throws ErroDePix, IOException {
    Conexao cn = null;
    // TODO Auto-generated method stub
    try {
      if (valor <= 0) {
        throw new ErroValorNaoPositivo();
      }
      if (chave.isBlank()) {
        throw new ErroChaveEmBranco();
      }
      cn = servidor.abrirConexao();
      String envioDePix = cn.enviarPix(valor, chave);
      if (envioDePix != "sucesso") {
        switch (envioDePix) {
          case "saldo_insuficiente":
            throw new ErroSaldoInsuficiente();
          case "chave_pix_nao_encontrada":
            throw new ErroChaveNaoEncontrada();
          default:
            throw new ErroInterno();
        }
      }
    } finally {
      if (cn != null) {
        cn.close();
      }
    }
  }
}
