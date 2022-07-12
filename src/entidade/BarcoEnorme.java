package entidade;

public class BarcoEnorme extends Barco {
	protected int coordenada[][] = new int[5][2];
	
	public void setCoordenada(int[][] coord){
		for (int x=0; x<5;x++){
			for(int y=0;y<2;y++){
				coordenada[x][y] = coord[x][y];
			}
		}
	}
	
	public int[][] getCoordenada(){
		return coordenada;
	}
	
}
