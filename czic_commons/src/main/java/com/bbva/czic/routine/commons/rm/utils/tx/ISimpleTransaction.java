package com.bbva.czic.routine.commons.rm.utils.tx;

/**
 * Interfaz que se utilizará para inyectar en los DAO las transacciones simples.
 *
 * @author Adesis
 *
 */
public interface ISimpleTransaction {

    /**
     * Invoca a la transacción.
     *
     * @param dtoIn
     *            Dto de entrada o entidad de entrada.
     * @return Entidad de salida, coincidirá con el dto de entrada en caso de que la transacción sea de entidad a entidad.
     */
    <I, IF, O, OF> O invoke(final I dtoIn);

}