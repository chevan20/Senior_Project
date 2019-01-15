package shaders;

public class StaticShader extends ShaderProgram{

	public static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	public static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	
	protected void bindAttributes() {
		super.bindAttribut(0, "position");
	}

	
	
}
