package computer_graphics_6;

public class LightSample {
	Vector3 L;//�ⷽ��
	Colors EL;//��ɫ
	public LightSample(Vector3 L ,Colors EL) {
		this.EL = EL;
		this.L = L;
	}
	@Override
	public boolean equals(Object obj) {
		LightSample ls = (LightSample) obj;
		return ls.EL.equals(EL) && ls.L.equals(L);
	}
}
