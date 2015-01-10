package com.bbva.czic.routine.commons.rm.utils.tx;

/**
 * Interfaz que se utilizará para inyectar en los DAO las transacciones paginadas.
 *
 * @author Adesis
 *
 */
public interface IPaginatedTransaction {

    /**
     * Invoca a la transacción.
     *
     * @param dtoIn
     *            Dto de entrada.
     * @return Dto de salida.
     */
    <I, IF, O, OF, E, EOF, POF> O invoke(final I dtoIn);

}
