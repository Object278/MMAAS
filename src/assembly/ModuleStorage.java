package assembly;

public interface ModuleStorage {
	int numOfModules();
	int edge();
	void link(int v, int w, int direction);
}
