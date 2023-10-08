package br.edu.ifpb.hicarobrasil.dac.library.business.dto;

import java.sql.Date;

public record ReserveDTO(long id, String responsible, Date loan, Date devolution, long bookID) {

}
