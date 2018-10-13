package computer_graphics_6;


public class PhongMaterial extends Material{
	public Colors diffuse, specular;//�����䣬���淴��
	public float shininess;//��ǿ������ǿ��
	public PhongMaterial(Colors diffuse, Colors specular, float shininess,
			float reflectiveness) {
		this.diffuse = diffuse;
		this.specular = specular;
		this.shininess = shininess;
		this.reflectiveness = reflectiveness;
	}
	
	public Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light)
	{//                   ����       λ��             ������         ����Ĺ�
		float NdotL = normal.dot(light.L);//������
        Vector3 H = (light.L.subtract(ray.dir)).normalize();
        float NdotH = normal.dot(H);//���淴��
        Colors diffuseTerm = this.diffuse.multi(Math.max(NdotL, 0));
        Colors specularTerm = this.specular.multi((float) Math.pow(Math.max(NdotH, 0), this.shininess));
        return light.EL.modulate(diffuseTerm.add(specularTerm));
	}
}
