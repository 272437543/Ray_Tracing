package computer_graphics_6;


public class PhongMaterial extends Material{
	public Colors diffuse, specular;//漫反射，镜面反射
	public float shininess;//光强，反射强度
	public PhongMaterial(Colors diffuse, Colors specular, float shininess,
			float reflectiveness) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.shininess = shininess;
		this.reflectiveness = reflectiveness;
	}
	
	public Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light)
	{//                   视线       位置             法向量         传入的光
		float NdotL = normal.dot(light.L);//漫反射
        Vector3 H = (light.L.subtract(ray.dir)).normalize();
        float NdotH = normal.dot(H);//镜面反射
        Colors diffuseTerm = this.diffuse.multi(Math.max(NdotL, 0));
        Colors specularTerm = this.specular.multi((float) Math.pow(Math.max(NdotH, 0), this.shininess));
        return light.EL.modulate(diffuseTerm.add(specularTerm));
	}
}
