import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ActivityIndicator, FlatList } from 'react-native';
import {useState, useEffect} from 'react';


export default function App() {
  const [loading, setLoading] = useState(true)
  const [todos, setTodos] = useState([])

  

  useEffect(()=>{
    fetch('https://jsonplaceholder.typicode.com/todos')
      .then(response => response.json())
      .then(data => {
        setTodos(data)
        setLoading(false)
      })
  },[])

  if(loading){
    return (
      <View style={styles.center}>
        <text>Cargando...</text>
        <ActivityIndicator
          size='large'
          color='#2457e3ff'
        />
      </View>
    )
  }

  return (
    <View style={styles.container}>
      <Text>Consumiendo datos de la API</Text>
      <FlatList
        data = {todos}
        renderItem = {({item}) => <View style={styles.item}>
          <Text>{item.title}</Text>
          <Text>{item.completed ? "👍":"👎"}</Text>
        </View>}
        keyExtractor = {item => String(item.id)}
      
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },

  center:{
    flex:1,
    alignItems:'center',
    justifyContent:'center',
  },

  item:{
    flexDirection:'row',
    justifyContent:'space-between',
    backgroundColor:'#5ef114ff',
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
    borderRadius:15,
  },

});
