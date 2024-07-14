package com.forohubalura.Forohub.dominio.topico;


import com.forohubalura.Forohub.dominio.curso.DatosRespuestaCurso;
import com.forohubalura.Forohub.dominio.usuario.DatosRespuestaUsuario;

import java.util.Date;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, Date fechaCreacion, DatosRespuestaUsuario autor,
                                   DatosRespuestaCurso curso) {
}
