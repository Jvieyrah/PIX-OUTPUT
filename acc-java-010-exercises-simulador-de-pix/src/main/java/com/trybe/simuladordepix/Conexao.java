package com.trybe.simuladordepix;

import java.io.Closeable;
import java.io.IOException;

/**
 * author joao.
 *
 */
public interface Conexao extends Closeable {

  String enviarPix(int valor, String chave) throws IOException;
}
