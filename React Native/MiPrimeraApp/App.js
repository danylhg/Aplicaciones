import { StatusBar } from 'expo-status-bar';
import React, {useState} from 'react';
import { StyleSheet, Text, View, TextInput, Button, ScrollView, Dimensions } from 'react-native';

let USER = "Paco";
let PASSWORD = "admin";

export default function App() {
  const [user, setUser] = useState("");
  const [pass, setPass] = useState("");
  const [message, setMessage] = useState("");
  const [color, setColor] = useState("black");


  const login = () => {
    if (user == USER && pass == PASSWORD){
      setMessage("Acceso autorizado");
      setColor("green");
    }else{
      setMessage("Acceso no autorizado");
      setColor("red");
    }
  };

  const cancel = () => {
      setUser("");
      setPass("");
      setMessage("");
  }

  return (
    <View style={styles.container}>
      <Text>LOGIN</Text>


      <TextInput 
        style = {styles.input}
        placeholder='Usuario'
        value={user}
        onChangeText={setUser}        
      />

      <TextInput 
        style = {styles.input}
        placeholder='Contraseña'
        secureTextEntry
        value={pass}
        onChangeText={setPass}
        
      />
      
      <Button title='Login'
        color="#00ff11ff"
        onPress={login}
      />

      <Button title='Cancelar'
        color="#ff0000ff"
        onPress={cancel}
      />

      <Text style={{ color, fontSize: 18, marginTop: 20 }}>
        {message}
      </Text>


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
  input: {
    height: 40,
    width:200,
    backgroundColor:"#befffcff",
    borderBottonColor: "#000000ff",
    borderBottonWith:1,
    padding:10,
    borderRadius:20,
    marginVertical: 10,
  },

});
