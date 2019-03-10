
public class Node 
{
int key;
String value;
public Node(int key, String value) 
{
	super();
	this.key = key;
	this.value = value;
}
public int getKey() {
	return key;
}
public void setKey(int key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String toString() {
	return "Node [key=" + key + ", value=" + value + "]";
}
}
