package com.trybe.simuladordepix;

import java.io.IOException;

/**
 * author joao.
 *
 */
public class ControladorDePix {

  private final ProcessadorDePix processadorDePix;

  public ControladorDePix(ProcessadorDePix processadorDePix) {
    this.processadorDePix = processadorDePix;
  }

  /**
   * Método a ser executado no momento em que a pessoa usuária confirmar a operação de Pix.
   *
   * @param valor Valor em centavos a ser transferido.
   * @param chave Chave Pix do beneficiário da transação.
   *
   * @return Mensagem a ser exibida à pessoa usuária, informando-a sobre o resultado da operação.
   */
  public String aoConfirmarPix(int valor, String chave) {
    String resp = "";
    try {
      processadorDePix.executarPix(valor, chave);
      resp = Mensagens.SUCESSO;
    } catch (ErroDePix err) {
      resp = err.getMessage();
    } catch (IOException err) {
      resp = Mensagens.ERRO_DE_CONEXAO;
    }
    return resp;
  }
}
