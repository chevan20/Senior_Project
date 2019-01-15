package renderEngine;

public class RawModel {
	
	private int vaoID;
	private int vertexCount;
	
	/**
	 *This class takes a rawModel and converts into VAOs for easy use in other places 
	 */
	public RawModel(int vaoID, int vertexCount) 
	{
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}
	
	public int getVaoID() 
	{
		return vaoID;
	}
	
	public int getVertexCount() 
	{
		return vertexCount;
	}

}
