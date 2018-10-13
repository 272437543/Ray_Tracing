package computer_graphics_6;

public class PointLight extends Light{
	Colors intensity;
	Vector3 position;
	boolean shadow;
	
	public PointLight(Colors intensity, Vector3 position, boolean shadow) {
		this.intensity = intensity;
		this.position = position;
		this.shadow = shadow;
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public LightSample sample(Union union, Vector3 position) {
		Vector3 delta = this.position.subtract(position);
		float r = delta.Length();
		float rr = r*r;
		Vector3 L = delta.devide(r);
		if(shadow)
		{
			Ray3 shadowRay = new Ray3(position, L);
            IntersectResult shadowResult = union.FinalResult(shadowRay);
            // 在r以内的相交点才会遮蔽光源
            if (shadowResult.Object != null && shadowResult.distance <= r)
                return new LightSample(new Vector3(), new Colors());
		}
		float attenuation = 1f / rr;
		return new LightSample(L, this.intensity.multi(attenuation));
	}
	
}
