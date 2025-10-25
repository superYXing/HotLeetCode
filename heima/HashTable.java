package heima;

public class HashTable {
	static class Entry{
		int hash;
		Object key;
		Object value;
		Entry next;
		public Entry(int hash, Object key, Object value) {
			this.hash = hash;
			this.key = key;
			this.value = value;
		}
	
	}
	Entry[] table  = new Entry[16];
	int size = 0; //元素个数
	float loadFactor = 0.75f;
	int threshold = (int) (loadFactor * table.length);
	Object get(int hash, Object key){
		int n = hash & (table.length-1);
		Entry e = table[n];
		if(e==null) return null;
		while(e!=null){
			if(e.key.equals(key)) return e.value;
			e = e.next;
		}
		return null;
	}

	void put(int hash, Object key, Object value){
		int n = hash & (table.length-1);

		if(table[n]==null){
			table[n] = new Entry(hash, key, value);
		} else{
			Entry e = table[n];
		while(true){
			if(e.key.equals(key)){
				e.value = value;
				return;
			}
			if(e.next==null) break;
			e = e.next;
		}
		e.next = new Entry(hash, key, value);
	}
		size++;
		if(size > threshold){
			resize();
		}
	}

	Object delete(int hash,Object key){
		int n = hash & (table.length-1);
		Entry e = table[n]; //链表的头结点
		if(e==null) return null;
		// 链表的删除，找到待删除结点
		Entry d = e;
		Entry prev = null;
		while(d!=null){
			if(d.key.equals(key)) break;
			prev = d;
			d = d.next;
		}
		if(d==null) return null;
		// 链表删除：区分头结点与非头结点
        if (prev == null) {
            table[n] = d.next;     // 删除头
        } else {
            prev.next = d.next;    // 删除中/尾
        }
		d.next=null;
		size--;
		return d.value;
	}

	void resize(){
		Entry[] newTable = new Entry[table.length << 1];
		for(int i = 0; i<table.length;i++){
			Entry p = table[i];
			if(p!=null){
				Entry a = null;
				Entry b = null;
				Entry aHead = null;
				Entry bHead = null;
				while(p!=null){
					if((p.hash&table.length) == 0){
					if(a!=null) a.next = p;
					else aHead = p;
					a = p;
					}
					else{
						if(b!=null) b.next = p;
						else bHead = p;
						b = p;
					}
					p = p.next;
				}
				if(a!=null){
					 a.next = null;
					 newTable[i] = aHead;
				}
				if(b!=null){
					b.next =null;
					newTable[i+table.length] = bHead;
				} 
			}
		}
		table = newTable;
		threshold = (int)(loadFactor * table.length);
	}

	public Object get(Object key){
		int hash = hash(key);
		return get(hash, key);
	}

	public Object delete(Object key){
		int hash = hash(key);
		return delete(hash,key);
	}

	public void put(Object key, Object value){
		int hash = hash(key);
		put(hash,key,value);
	}
	private int hash(Object key){
		return key.hashCode();
	}
	public static void main(String[] args) {
        HashTable ht = new HashTable();

        // // 1) 空桶插入
        // String k1 = "one";
        // ht.put(k1.hashCode(), k1, 1);
        // System.out.println("get(one) = " + ht.get(k1.hashCode(), k1)); // 1
        // System.out.println("size = " + ht.size); // 1

		
        // ht.put(k1.hashCode(), k1, 100);
        // System.out.println("get(one) after update = " + ht.get(k1.hashCode(), k1)); // 100
        // System.out.println("size = " + ht.size); // 仍为 1

        // // 3) 碰撞示例："FB" 与 "Ea" 的 hashCode 相同
        // String k2 = "FB";
        // String k3 = "Ea";
        // System.out.println("\"FB\" hash=" + k2.hashCode() + ", index=" + (k2.hashCode() & 15));
        // System.out.println("\"Ea\" hash=" + k3.hashCode() + ", index=" + (k3.hashCode() & 15));
        // ht.put(k2.hashCode(), k2, 2);
        // ht.put(k3.hashCode(), k3, 3);
        // System.out.println("get(FB) = " + ht.get(k2.hashCode(), k2)); // 2
        // System.out.println("get(Ea) = " + ht.get(k3.hashCode(), k3)); // 3
        // System.out.println("size = " + ht.size); // 3

        // // 4) 删除头结点
        // Object removedOne = ht.delete(k1.hashCode(), k1);
        // System.out.println("delete(one) -> " + removedOne + ", get(one) = " + ht.get(k1.hashCode(), k1));
        // System.out.println("size = " + ht.size); // 2

        // // 5) 删除碰撞链中的一个
        // Object removedFB = ht.delete(k2.hashCode(), k2);
        // System.out.println("delete(FB) -> " + removedFB + ", get(FB) = " + ht.get(k2.hashCode(), k2));
        // System.out.println("size = " + ht.size); // 1

        // // 6) 删除不存在的 key
        // Object removedNope = ht.delete("nope".hashCode(), "nope");
        // System.out.println("delete(nope) -> " + removedNope); // null
        // System.out.println("size = " + ht.size); // 不变

		// resize 测试：插入 13 个元素触发扩容（阈值=12）
        HashTable ht2 = new HashTable();
        for (int i = 0; i < 13; i++) {
            String k = "k" + i;
            ht2.put(k.hashCode(), k, i);
        }
        // 校验容量翻倍
        assert ht2.table.length == 32 : "resize failed, length=" + ht2.table.length;
        // 校验数据完整性
        for (int i = 0; i < 13; i++) {
            String k = "k" + i;
            assert ht2.get(k.hashCode(), k).equals(i) : "data lost: " + k;
        }
        System.out.println("resize test passed");
    }
}
