## Running the simulation

To run the .tcl file, this will create three .tr (trace) files (file1.tr , file2,tr , pa3.tr).
```
ns pa3.tcl
```

To run the .awk file to read the .tr files and create variables a1 and a2 for xgraph.
```
awk -f pa3.awk file1.tr > a1
awk -f pa3.awk file2.tr > a2
```

## Run xgraph

Run xgraph with the newly created variables a1 and a2.
```
xgraph a1 a2
```
