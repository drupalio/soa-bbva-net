package com.bbva.czic.routine.commons.rm.utils.tx;

/**
 * Mapper para invocar a una transacción que pagina.
 *
 * @author Adesis
 *
 * @param <I>
 *            Tipo del dto de entrada.
 * @param <IF>
 *            Tipo del formato de entrada de la transacción.
 * @param <O>
 *            Tipo de la dto de salida.
 * @param <OF>
 *            Tipo del formato de salida de la transacción. Si no aplica este formato se inferirá como tipo la interfaz IFormatNotApply.
 * @param <E>
 *            Tipo de la entidad destino de la cual el dto de salida tendrá una lista.<br />
 *            Por ejemplo, en la consulta de cuentas de un usuario, habrá un dto de salida que encapsulará una lista del tipo de la entidad
 *            Cuenta.
 * @param <EOF>
 *            Tipo del formato de salida donde está el detalle de cada entidad.
 * @param <POF>
 *            Tipo del formato de salida de paginación de la transacción.
 */
public interface IPaginatedTransactionMapper<I, IF, O, OF, E, EOF, POF> extends ISimpleTransactionMapper<I, IF, O, OF> {

    /**
     * Mapea desde el formato de salida a la entidad.
     *
     * @param outFormat Formato de salida de la entidad.
     * @param dtoIn     Dto de entrada que puede ser utilizado para completar información de la entidad si el formato de salida no la trae.
     * @return Datos de la entidad.
     */
    E mapToInnerEntity(EOF outFormat, I dtoIn);

    /**
     * Añade la información de paginación recibida por la transacción en el formato de salida de paginación en el dto de entrada.
     *
     * @param paginationOutFormat Formato de salida de paginación.
     * @param dtoIn               Dto de entrada.
     */
    void addPaginationInfo(POF paginationOutFormat, I dtoIn);

    /**
     * Indica si se tiene que paginar y por lo tanto volver a invocar a la transacción. Este método, a partir de la información de
     * paginación añadida en el método addPaginationInfo al dto de entrada, tendrá la lógica para indicar si paginar o no.
     *
     * @param dtoIn Dto de entrada donde previamente se habrá almacenado la información de paginación obtenida del formato de salida de
     *              paginación de la transacción.
     * @return true si hay que volver a invocar a la transacción, false en caso contrario.
     */
    boolean doIHaveToPaginate(I dtoIn);

}