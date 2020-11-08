class Gen<T> {

    T tarray[];

    Gen(T arr[]) {
        tarray = arr;
    }

    T getSpecifiedItem(int i) {
        return tarray[i];
    }
}