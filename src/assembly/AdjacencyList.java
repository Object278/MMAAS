package assembly;

import java.util.ArrayList;
import java.util.HashMap;

import component.Linkable;

public class AdjacencyList implements ModuleStorage {
	//专门用来存储无向图的邻接表
	//n是顶点数，m是边的数量
	private int n=0, m=0;
	boolean directed = false;
	ArrayList<ArrayList<Integer>> list;
	HashMap<Integer, Linkable> numToModule;
	boolean isProxy;
	
	public class AdjIterator{
		private AdjacencyList adjList;
		int v;//v是被遍历的节点
		int index;//当前遍历到的节点
		
		public AdjIterator(AdjacencyList adjList, int v) {
			this.adjList=adjList;
			this.v=v;
			this.index=0;
		}
		
		public int begin() {
			//每次调用begin的时候index都要归零
			index=0;
			if(adjList.list.get(v).size() != 0) {
				return (int)adjList.list.get(v).get(index);
			}
			return -1;
		}
		
		public int next() {
			index++;
			if( index<adjList.list.get(v).size() ) {;
				return (int)adjList.list.get(v).get(index);
			}
			return -1;
		}
		
		public boolean end() {
			return index >= adjList.list.get(v).size();
		}
	}
	
	public AdjacencyList() {
		this.isProxy = false;
		list=new ArrayList<>(512);
		numToModule = new HashMap<>();
	}
	
	/*
	 * Wenn you want to create a Proxy of this class, you can set is Proxy to true;
	 */
	public AdjacencyList(boolean isProxy) {
		if(isProxy) {
			list = null;
			numToModule = null;
		}else {
			this.isProxy = isProxy;
			list=new ArrayList<>(512);
			numToModule = new HashMap<>();
		}
	}
	
	@Override
	public int numOfModules() {
		if(isProxy) {
			return 0;
		}
		return n;
	}
	
	@Override
	public int edge() {
		if(isProxy) {
			return 0;
		}
		return m;
	}
	
	@Override
	//表示v和w节点有连接
	//需要把这个方法修改为添加的时候必须指明从哪个面（方向）添加
	//0-x正方向，1-x负方向，2-y正方向，3-y负方向，4-z正方向，5-z负方向。
	//有些模块只允许从两个方向添加
	public void link(int v, int w, int direction) {
		if(isProxy) {
			return;
		}
		if(v<0 || w<0 ) {
			throw new IllegalArgumentException("Parameters must be bigger than 0.");
		}
		if(v>=n || w>=n) {
			throw new IllegalArgumentException("The number of Modules is too much. What r u doing?");
		}
		if(!numToModule.containsKey(v) || !numToModule.containsKey(w)) {
			throw new IllegalArgumentException("Please create the Module and add it to numToModule by using addModule()");
		}
		if(list.get(v) == null) {
			list.set(v, new ArrayList<Integer>(numToModule.get(v).getLinkNumber()));
		}
		//在模块的组件中不允许自环边（自己连接自己），平行边（一个面上连接多个其他模块）
		//这里的处理方式是让添加无效，不报错，处理成报错也可以
		//并且模块是用无向图存储
		if(!list.get(v).contains(w) && v != w && !directed) {
			list.get(v).set(direction, w);
			list.get(w).set(direction, w);
			m++;
		}
	}
	
	public void addModule(int id, Linkable module) {
		if(isProxy) {
			return;
		}
		if(numToModule.containsKey(id)) {
			throw new IllegalArgumentException("One ID can only map to one module");
		}
		numToModule.put(id, module);
	}
	
	public boolean hasEdge(int v, int w) {
		if(isProxy) {
			return false;
		}
		if(v<0 || v>=n || w<0 || w>=n) {
			throw new IllegalArgumentException("Error");
		}
		for(int i=0; i<list.get(v).size(); i++) {
			if((int)list.get(v).get(i) == w) {
				return true;
			}
		}
		return false;
	}
	
	public void show() {
		if(isProxy) {
			return;
		}
		for(int i=0; i<n; i++) {
			System.out.print("Module"+i+": ");
			for(int j=0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public HashMap<Integer, Linkable> getNumToModule() {
		return numToModule;
	}

	public boolean isProxy() {
		return isProxy;
	}

	public static void main(String[] args) {
		
	}

}
