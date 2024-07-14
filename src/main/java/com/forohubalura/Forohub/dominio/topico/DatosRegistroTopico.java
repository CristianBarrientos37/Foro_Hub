package com.forohubalura.Forohub.dominio.topico;

import com.forohubalura.Forohub.dominio.curso.Curso;
import com.forohubalura.Forohub.dominio.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String status,

        @NotNull
        Usuario autor,

        @NotNull
        Curso curso
) {
}
