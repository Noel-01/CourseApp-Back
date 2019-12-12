package com.mybatis.courses.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page {

	private int totalPaginas;
	private int paginaActual;
	private int paginaSiguiente;
	private int paginaAnterior;
	private boolean primeraPagina;
	private boolean ultimaPagina;
	private int totalElementos;
	private int elementosPagina;
	private List<?> list;
	private int limit1;
	private int limit2;
	
}
