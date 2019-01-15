package renderEngine;

import java.util.List;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Loader {

	/**
	 * These Lists create ID's for all of the vertex positions that we will be using to render obj files on the screen
	 */
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	
	/**
	 * This void take a RawModel and loads it into a VAO
	 * This allows us to call this void to pick a VAO, find what it does and call it when we want to create that object
	 */
	public RawModel loadToVAO(float[] positions, int[] indices) 
	{
		
		int vaoID = createVAO();
		bindIndicesBuffer(indices);
		storeDataInAttributeList(0, positions);
		unbindVAO();
		//The three here is the number of points per vertex if you need more, make number bigger
		return new RawModel(vaoID, indices.length);
		
	}
	
	/**
	 * This void cleans up any extra VAOs and VBOs that we might have
	 */
	public void cleanUp() 
	{
		for(int vao:vaos) 
		{
			GL30.glDeleteVertexArrays(vao);
		}
		for(int vbo:vbos) 
		{
			GL15.glDeleteBuffers(vbo);
		}
	}
	
	/**
	 * This void creates the VAO which stores all of the vertex positions, X, Y, Z
	 */
	private int createVAO()
	{
		
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		return vaoID;
		
	}
	
	
	/**
	 *This takes the data we have and stores it into the VBOs we want it to
	 */
	private void storeDataInAttributeList(int attributeNumber, float[] data) 
	{
		
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
	}
	
	/**
	 * This Clears up a VAO for use again
	 */
	private void unbindVAO() 
	{
		
		GL30.glBindVertexArray(0);
		
	}
	
	
	private void bindIndicesBuffer(int[] indices) 
	{
		
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDataInIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
	}
	
	private IntBuffer storeDataInIntBuffer(int[] data) 
	{
		
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
		
	}
	
	/**
	 * This takes the VBOs we have and readies them up for use
	 */
	private FloatBuffer storeDataInFloatBuffer(float[] data) 
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
}
