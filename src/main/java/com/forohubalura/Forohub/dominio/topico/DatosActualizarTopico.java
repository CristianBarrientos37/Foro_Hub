package com.forohubalura.Forohub.dominio.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje,
                                    String status) {
}
