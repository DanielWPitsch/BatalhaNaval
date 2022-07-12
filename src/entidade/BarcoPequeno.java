package entidade;

public class BarcoPequeno extends Barco {
	protected int coordenada[][] = new int[2][2];
	
	public void setCoordenada(int[][] coord){
		for (int x=0; x<2;x++){
			for(int y=0;y<2;y++){
				coordenada[x][y] = coord[x][y];
			}
		}
	}
	
	public int[][] getCoordenada(){
		return coordenada;
	}
	
}
