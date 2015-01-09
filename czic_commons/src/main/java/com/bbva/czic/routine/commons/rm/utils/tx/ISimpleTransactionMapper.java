package com.bbva.czic.routine.commons.rm.utils.tx;

/**
 * Mapper simple para invocar a una transacción simple, ya sea de dto de entrada a entidad o de entidad a entidad.
 *
 * @author Adesis
 *
 * @param <I>
 *            Tipo del dto de entrada, puede ser un dto que representa a una entidad.
 * @param <IF>
 *            Tipo del formato de entrada de la transacción.
 * @param <O>
 *            Tipo de la entidad destino de la transacción, coincidirá con el tipo <I> si el mapper es de entidad a entidad, ya que la
 *            entidad tendrá campos de entrada y de salida.
 * @param <OF>
 *            Tipo del formato de salida de la transacción.
 */
public interface ISimpleTransactionMapper<I, IF, O, OF> {

    /**
     * Mapea del dto de entrada o entidad de entrada al formato de entrada de la transacción.
     *
     * @param dtoIn
     *            Dto o entidad de entrada.
     * @return Formato de entrada a la transacción.
     */
    IF mapToInner(I dtoIn);

    /**
     * Mapea desde el formato de salida al dto de salida de la transacción. Si el mapper es de entidad a entidad este método deberá
     * completar el dto de entrada pasado como parámetro y devolverlo como respuesta del método.
     *
     * @param outFormat
     *            Formato de salida de la transacción.
     * @param dtoIn
     *            Dto de entrada. Al que mapear la salida de la transacción en caso de ser una entidad, o se podrá utilizar para completar
     *            el dto de salida como campos que no devuelve la transacción.
     * @return Entidad respuesta, si el mapper es de entidad a entidad se devolverá el dto de entrada como salida.
     */
    O mapToOuter(OF outFormat, I dtoIn);

}