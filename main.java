package main;

import mod.Msg;

public class main {
	
	private boolean[][] lights;

	public static void main(String[] args0) {
		openPage();
	}
	
	public static void openPage() {
		String r = Msg.in("Pick a number of rows:");
		int row = Integer.parseInt(r);
		String c = Msg.in("Pick a number of columns:");
		int col = Integer.parseInt(c);
		
			boolean[][] lights = new boolean[row][col];
			for (int i = 0; i < lights.length; i++) {
				for (int j = 0; j < lights[0].length; j++) {
					double rnd = Math.random();
					if (rnd >= 0.40) {
						lights[i][j] = true;
					}
					else {
						lights[i][j] = false;
					}
				}
			}
			Msg.msg("Here is your light board: " + "\n" + "the '1' means ON and the '0' means OFF" + "\n" + drawBoard(lights) + "Click 'Ok' to continue:");
			editPage(drawBoard(lights), lights);

	}
	
	public static String drawBoard(boolean[][] lB) {
		String on = "1";
		String off = "0";
		String space = " ";
		String BOARD = "";
		for (int r = 0; r < lB.length; r++) {
			for (int c = 0; c < lB[0].length; c++) {
				if (lB[r][c]) {
					BOARD += on + space;
				}
				else {
					BOARD += off + space;
				}
			}
			BOARD += "\n";
		}
		return BOARD;
	}
	
	public static void editPage(String drawnB, boolean[][] lB) {
		String[] options = {"a Row", "a Column", "a single light", "the entire grid", "a certain section", "random", "exit"};
		int opts = 0;
		opts = Msg.opt(options, drawnB + "\n" +"What would you like to edit on your LightBoard: ", "LightBoard");
		if (opts == 0) {
			entireRow(drawnB, lB);
		}
		else if (opts == 1) {
			entireCol(drawnB, lB);
		}
		else if (opts == 2) {
			singleLight(drawnB, lB);
		}
		else if (opts == 3) {
			entireGrid(drawnB, lB);
		}
		else if (opts == 4) {
			cSection(drawnB, lB);
		}
		else if (opts == 5) {
			random(drawnB, lB);
		}
		else if (opts == 6) {
			exit(drawnB, lB);
		}
	}
	
	public static void entireRow(String drawnB, boolean[][] lB) {
		String ro = Msg.in(drawnB + "\n" + "What row would you like to edit? " + "\n" + "(keep in mind that the first row is considered 'row 0')");
		int row = Integer.parseInt(ro);
		String[] options = {"On", "Off"};
		int opts = 0;
		opts = Msg.opt(options, "Would you like these lights to be turned on or off?", "LightBoard");
		if (opts == 0) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (r == row) {
						lB[r][c] = true;
					}
				}
			}
		}
		else if (opts == 1) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (r == row) {
						lB[r][c] = false;
					}
				}
			}
		}
		
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
	
	public static void entireCol(String drawnB, boolean[][] lB) {
		String co = Msg.in(drawnB + "\n" + "What column would you like to edit? " + "\n" + "(keep in mind that the first column is considered 'column 0')");
		int col = Integer.parseInt(co);
		String[] options = {"On", "Off"};
		int opts = 0;
		opts = Msg.opt(options, "Would you like these lights to be turned on or off?", "LightBoard");
		if (opts == 0) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (c == col) {
						lB[r][c] = true;
					}
				}
			}
		}
		else if (opts == 1) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (c == col) {
						lB[r][c] = false;
					}
				}
			}
		}
		
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
	
	
	public static void singleLight(String drawnB, boolean[][] lB) {
		String ro = Msg.in(drawnB + "\n" + "What row would you like to edit? " + "\n" + "(keep in mind that the first row is considered 'row 0')");
		int row = Integer.parseInt(ro);
		String co = Msg.in(drawnB + "\n" + "What column would you like to edit? " + "\n" + "(keep in mind that the first column is considered 'column 0')");
		int col = Integer.parseInt(co);
		String[] options = {"On", "Off"};
		int opts = 0;
		opts = Msg.opt(options, "Would you like this light to be turned on or off?", "LightBoard");
		if (opts == 0) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (c == col && r == row) {
						lB[r][c] = true;
					}
				}
			}
		}
		else if (opts == 1) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (c == col && r == row) {
						lB[r][c] = false;
					}
				}
			}
		}
		
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
	
	public static void entireGrid(String drawnB, boolean[][] lB) {
		String[] options = {"On", "Off"};
		int opts = 0;
		opts = Msg.opt(options, "Would you like the lights to be turned on or off?", "LightBoard");
		if (opts == 0) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					lB[r][c] = true;
				}
			}
		}
		else if (opts == 1) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					lB[r][c] = false;
				}
			}
		}
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
		
	
	public static void cSection(String drawnB, boolean[][] lB) {
		String sRo = Msg.in(drawnB + "\n" + "What start row would you like? " + "\n" + "(keep in mind that the first row is considered 'row 0')");
		int sRow = Integer.parseInt(sRo);
		String sCo = Msg.in(drawnB + "\n" + "What start column would you like? " + "\n" + "(keep in mind that the first column is considered 'column 0')");
		int sCol = Integer.parseInt(sCo);
		String eRo = Msg.in(drawnB + "\n" + "What end row would you like? " + "\n" + "(keep in mind that the first row is considered 'row 0')");
		int eRow = Integer.parseInt(eRo);
		String eCo = Msg.in(drawnB + "\n" + "What end column would you like? " + "\n" + "(keep in mind that the first column is considered 'column 0')");
		int eCol = Integer.parseInt(eCo);
		String[] options = {"On", "Off"};
		int opts = 0;
		opts = Msg.opt(options, "Would you like these lights to be turned on or off?", "LightBoard");
		if (opts == 0) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (r == sRow && c == sCol) {
						for (int r1 = sRow; r1 <= eRow; r1++) {
							for (int c1 = sCol; c1 <= eCol; c1++) {
								lB[r1][c1] = true;
							}
						}
					}
				}
			}
		}
		else if (opts == 1) {
			for (int r = 0; r < lB.length; r++) {
				for (int c = 0; c < lB[0].length; c++) {
					if (r == sRow && c == sCol) {
						for (int r1 = sRow; r1 <= eRow; r1++) {
							for (int c1 = sCol; c1 <= eCol; c1++) {
								lB[r1][c1] = false;
							}
						}
					}
				}
			}
		}
		
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
	
	public static void random(String drawnB, boolean[][] lB) {
		for (int r = 0; r < lB.length; r++) {
			for (int c = 0; c < lB[0].length; c++) {
				double rnd = Math.random();
				if (rnd >= 0.50) {
					lB[r][c] = true;
				}
				else {
					lB[r][c] = false;
				}
			}
		}
		String newB = drawBoard(lB);
		editPage(newB, lB);
	}
	

	
	
	public static void exit(String drawnB, boolean[][] lB) {
		String[] options = {"Yes", "No"};
		int opts = 0;
		opts = Msg.opt(options, "Are you sure you would like to exit?", "LightBoard");
		if (opts == 0) {
			Msg.msg("GOODBYE!");
		}
		if (opts == 1) {
			openPage();
		}
	}

	
}
