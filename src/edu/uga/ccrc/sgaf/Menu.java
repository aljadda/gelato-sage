package edu.uga.ccrc.sgaf;


	public enum Menu {
		GELATO_ANNOTATE("(1) Annotate using GELATO"),
		TRAIN_NEW("(2) Train a new SAGE"), 
		TRAIN_EXISTING("(3) Train Existing SAGE"), 
		SAGE_ANNOTATE("(4) Annotate using SAGE"), 
		SAGE_FILTER("(5) Filter GELATO annotations using SAGE"), 
		EXIT("(6) Exit");

		private String menuText;

		Menu(String menuText) {
			this.menuText = menuText;
		}

		public String getMenuText() {
			return menuText;

		}

	}


