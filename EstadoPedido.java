/**
     * EstadoPedido - Enum de estados del pedido
     */

    const EstadoPedido = Object.freeze({
        PENDIENTE: "PENDIENTE",
        CONFIRMADO: "CONFIRMADO",
        ENVIADO: "ENVIADO",
        ENTREGADO: "ENTREGADO"
        CANCELADO: "CANCELADO"
        DESPACHADO: "DESPACHADO"
    });

    /**
    * EstadoEnvio - Enum de estados del envío
    */

    const EstadoEnvio = Object.freeze({
        PENDIENTE: "PENDIENTE"
        EN_RUTA: "EN_RUTA"
        ENTREGADO: "ENTREGADO"
        DEVUELTO: "DEVUELTO"
    });

    module.exports= {EstadoPedido, EstadoEnvio};
