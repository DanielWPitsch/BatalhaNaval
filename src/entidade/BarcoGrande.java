package entidade;

public class BarcoGrande extends Barco {
	protected int coordenada[][] = new int[4][2];
	
	public void setCoordenada(int[][] coord){
		for (int x=0; x<4;x++){
			for(int y=0;y<2;y++){
				coordenada[x][y] = coord[x][y];
			}
		}
	}
	
	public int[][] getCoordenada(){
		return coordenada;
	}
	
}
