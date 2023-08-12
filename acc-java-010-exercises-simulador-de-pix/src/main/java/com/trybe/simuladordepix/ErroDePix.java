package com.trybe.simuladordepix;

/**
 * author joao.
 *
 */
public abstract class ErroDePix extends Exception {
  /** Método default serial version. */
  private static final long serialVersionUID = 1L;

  public ErroDePix(String mensagem) {
    super(mensagem);
  }
}
