# SearchableRecyclerView
Searchable recycler view

###### The most easy to use recycler view with searching capability.
## Getting Started

This tiny library helps you to make your recycler views searchable.
### Prerequisites
Android studio with gradle version 3.0+

### Installing

Add this items in your build.gradle file
```
Step 1:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  Step 2:
dependencies {
	        implementation 'com.github.MoeidHeidari:SearchableRecyclerView:0.1.0'
	}
```

## How to use
```
Steps 1 : 
Add it to your *.xml file
 <com.example.searchablerecyclerview2.SearchableRecyclerView
        android:id="@+id/MainRecyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
         />
        
Steps 2 :

In your activity


recyclerView.performSearch(YourListItems,yourEditText,ViewModel.class);
        mainRecyclerView.setSearchListener(new SearchableRecyclerView.RecyclerSearchListener() {
            @Override
            public void foundedItems(List<?> foundeds)
            {
               //update the recycler view with founded items and also cast the founded items to your own type
               // (List<ViewModel>)foundeds
            }
        });
        
```
## Author

* **Moeid Heidari** 

## And a special thanks to everyone who helped me

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
