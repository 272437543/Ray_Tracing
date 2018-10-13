package computer_graphics_6;

public class Union {
	private final float INF = 1000000f;
	private SceneObject[] objects;
	public Union(SceneObject[] objects) {
		this.objects = objects;
	}
	public void init()
	{
		for(int i=0; i<objects.length; i++)
			objects[i].init();
	}
	public IntersectResult FinalResult(Ray3 ray)
	{
		float minDistance = INF;
		IntersectResult finalResult = new IntersectResult();
		for(int i=0; i<objects.length; i++)
		{
			IntersectResult result = objects[i].intersect(ray);
			if(result.Object!=null && result.distance < minDistance)
			{
				minDistance = result.distance;
				finalResult = result;
			}
		}
		return finalResult;
	}
}
