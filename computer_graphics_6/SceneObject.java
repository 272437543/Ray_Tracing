package computer_graphics_6;

public abstract class SceneObject {
	public Material material;
	public abstract void init();
	public abstract IntersectResult intersect(Ray3 ray);
}
