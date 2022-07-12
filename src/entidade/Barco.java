package entidade;

public abstract class Barco {
	protected int coordenada[][] = new int[1][2]; //tamanho e 2 coordenadas: linha, coluna

	public abstract int[][] getCoordenada();
	
	public abstract void setCoordenada(int[][] coord);

}
