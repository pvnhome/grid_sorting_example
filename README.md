# Vaadin Grid sorting example

## Sorting and filtering

Clone and run:

```
git clone https://github.com/pvnhome/grid_sorting_example.git
cd grid_sorting_example
gradlew appRun
```

Project should soon then be running on http://localhost:8080/sortgrid/

You can see described above behavior in simplified log:

```
SortgridView
sizeInBackEnd: 200, sort=[], filter=absent
fetchFromBackEnd: offset=0, limit=50, sort=[id (D)], filter=absent
sizeInBackEnd: 200, sort=[], filter=absent
fetchFromBackEnd: offset=0, limit=50, sort=[], filter=absent
fetchFromBackEnd: offset=50, limit=100, sort=[], filter=absent
```

On button click sorting working as expected:


```
button: sort 1
sizeInBackEnd: 200, sort=[], filter=absent
fetchFromBackEnd: offset=0, limit=150, sort=[c (A),id (A)], filter=absent

button: filter on
sizeInBackEnd: 100, sort=[], filter=[need to filter]
fetchFromBackEnd: offset=0, limit=100, sort=[c (A),id (A)], filter=[need to filter]
```

## No sorting


Variant without initial sorting:

```
git checkout without_initial_sort
gradlew appRun
```

Log:


```
SortgridView
sizeInBackEnd: 200, sort=[], filter=absent
fetchFromBackEnd: offset=0, limit=50, sort=[], filter=absent
fetchFromBackEnd: offset=50, limit=100, sort=[], filter=absent
```

## Sorting using provider


```
git checkout provider_sort
gradlew appRun
```

Log:


```
SortgridView
sizeInBackEnd: 200, sort=[id (D)], filter=absent
fetchFromBackEnd: offset=0, limit=50, sort=[id (D)], filter=absent
fetchFromBackEnd: offset=50, limit=100, sort=[id (D)], filter=absent
```

Sorting working but not visible in the grid.