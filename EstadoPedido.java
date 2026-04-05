/**
     * EstadoPedido - Enum de estados del pedido
     */

    public enum EstadoPedido {
        PENDIENTE,
        CONFIRMADO,
        ENVIADO,
        ENTREGADO,
        CANCELADO,
        DESPACHADO
    }

    /**
     * EstadoEnvio - Enum de estados del envío
     */
    public enum EstadoEnvio {
        PENDIENTE,
        EN_RUTA,
        ENTREGADO,
        DEVUELTO
    }

