package computer_graphics_6;

public class CheckBoardMaterial extends Material{
	float scale;
	public CheckBoardMaterial(float scale, float reflectiveness) {
		this.scale = scale;
		this.reflectiveness = reflectiveness;
	}
	public Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light)
	{
		return Math.abs((int)(Math.floor(position.x * this.scale) + Math.floor(position.z * this.scale)) % 2) < 1 
				? new Colors(0, 0, 0).modulate(light.EL) : new Colors(1, 1, 1).modulate(light.EL);
	}
}
