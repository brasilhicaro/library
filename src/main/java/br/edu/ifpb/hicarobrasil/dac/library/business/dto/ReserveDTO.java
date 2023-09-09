package br.edu.ifpb.hicarobrasil.dac.library.business.dto;

import java.sql.Date;

public record ReserveDTO(String name, Date loan, Date devolution, long bookID) {

}
