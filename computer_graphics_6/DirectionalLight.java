package computer_graphics_6;


public class DirectionalLight extends Light{
	
	Vector3 direction;
	boolean shadow;
	Colors irradiance;
	Vector3 L;
	public DirectionalLight(Colors irradiance, Vector3 direction, boolean shadow) {
		this.irradiance = irradiance;
		this.direction = direction;
		this.shadow = shadow;
	}
	public void init()
	{
		L = direction.normalize().negate();
	}
	public LightSample sample(Union union, Vector3 position)
	{
		if(shadow)
		{
			Ray3 shadowRay = new Ray3(position, L);
			IntersectResult shadowResult = union.FinalResult(shadowRay);
			if(shadowResult.Object!=null)
			{
				return new LightSample(new Vector3(), new Colors(0, 0, 0));
			}
		}
		return new LightSample(L, irradiance);
	}
}
