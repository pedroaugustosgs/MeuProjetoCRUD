package JanelaAluno;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloDaTabela extends AbstractTableModel{

	String colunas[];
	ArrayList linhas;
	
	public ModeloDaTabela(String c[],ArrayList l) {
		colunas = c;
		linhas = l;
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		Object linha[] = (Object[]) getLinhas().get(l);
		return linha[c];
	}

	public String getColumnName(int posicao) {
		return colunas[posicao];
	}
	
	/*@Override //para o checkbox aparecer na tabela
    public Class<?> getColumnClass(int columnIndex) {
		//Object[] linha = (Object[])getLinhas().get(0);
		//return linha[columnIndex].getClass(); //do tipo boolean aparece um checkbox
		if(columnIndex >3 && columnIndex < 14) {
			return Boolean.class;
		}
       return String.class;
    }
	*/
	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}
	
}