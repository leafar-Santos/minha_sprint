package com.soft.quality.if_yes_if_no_teste.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	
		private static final long serialVersionUID = 1L;

		private String campo;
		private String message;

		public FieldMessage() {
			super();
			// TODO Auto-generated constructor stub
		}

		public FieldMessage(String campo, String message) {
			super();
			this.campo = campo;
			this.message = message;
		}

		public String getCampo() {
			return campo;
		}

		public void setCampo(String campo) {
			this.campo = campo;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
