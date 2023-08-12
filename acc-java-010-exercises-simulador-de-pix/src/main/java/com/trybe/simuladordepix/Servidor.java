package com.trybe.simuladordepix;

import java.io.IOException;

/**
 * author joao.
 *
 */
public interface Servidor {

  Conexao abrirConexao() throws IOException;
}
