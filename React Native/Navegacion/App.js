import React, { useState } from "react";
import { Button, Text, TextInput, View, StyleSheet } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

const Stack = createNativeStackNavigator();

/* ================= Pantalla Principal ================= */
function HomeScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Mini Apps</Text>
      <Button title="Calculadora IMC" onPress={() => navigation.navigate("IMC")} />
      <Button title="Cambio de Divisas" onPress={() => navigation.navigate("Divisas")} />
      <Button title="Cálculo de Propinas" onPress={() => navigation.navigate("Propinas")} />
    </View>
  );
}

/* ================= IMC ================= */
function IMCScreen() {
  const [peso, setPeso] = useState("");
  const [altura, setAltura] = useState("");
  const [resultado, setResultado] = useState("");

  const calcularIMC = () => {
    if (peso && altura) {
      const imc = parseFloat(peso) / Math.pow(parseFloat(altura), 2);
      let estado = "";
      if (imc < 18.5) estado = "Bajo peso";
      else if (imc < 24.9) estado = "Normal";
      else if (imc < 29.9) estado = "Sobrepeso";
      else estado = "Obesidad";

      setResultado(`IMC: ${imc.toFixed(2)} - ${estado}`);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Calculadora de IMC</Text>
      <TextInput
        style={styles.input}
        placeholder="Peso (kg)"
        keyboardType="numeric"
        value={peso}
        onChangeText={setPeso}
      />
      <TextInput
        style={styles.input}
        placeholder="Altura (m)"
        keyboardType="numeric"
        value={altura}
        onChangeText={setAltura}
      />
      <Button title="Calcular" onPress={calcularIMC} />
      <Text style={styles.result}>{resultado}</Text>
    </View>
  );
}

/* ================= Divisas ================= */
function DivisasScreen() {
  const [monto, setMonto] = useState("");
  const [resultado, setResultado] = useState("");
  const tasa = 18.5; // ejemplo USD → MXN

  const convertir = () => {
    if (monto) {
      const mxn = parseFloat(monto) * tasa;
      setResultado(`${monto} USD = ${mxn.toFixed(2)} MXN`);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Cambio de Divisas</Text>
      <TextInput
        style={styles.input}
        placeholder="Monto en USD"
        keyboardType="numeric"
        value={monto}
        onChangeText={setMonto}
      />
      <Button title="Convertir a MXN" onPress={convertir} />
      <Text style={styles.result}>{resultado}</Text>
    </View>
  );
}

/* ================= Propinas ================= */
function PropinasScreen() {
  const [cuenta, setCuenta] = useState("");
  const [personas, setPersonas] = useState("");
  const [resultado, setResultado] = useState("");

  const calcular = (porcentaje) => {
    if (cuenta && personas) {
      const total = parseFloat(cuenta) * (1 + porcentaje);
      const porPersona = total / parseFloat(personas);
      setResultado(`Cada persona paga: $${porPersona.toFixed(2)}`);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Cálculo de Propinas</Text>
      <TextInput
        style={styles.input}
        placeholder="Cuenta total"
        keyboardType="numeric"
        value={cuenta}
        onChangeText={setCuenta}
      />
      <TextInput
        style={styles.input}
        placeholder="Número de personas"
        keyboardType="numeric"
        value={personas}
        onChangeText={setPersonas}
      />
      <View style={{ marginVertical: 10 }}>
        <Button title="Propina 10%" onPress={() => calcular(0.1)} />
        <Button title="Propina 15%" onPress={() => calcular(0.15)} />
        <Button title="Propina 20%" onPress={() => calcular(0.2)} />
      </View>
      <Text style={styles.result}>{resultado}</Text>
    </View>
  );
}

/* ================= APP con Stack ================= */
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Inicio" component={HomeScreen} />
        <Stack.Screen name="IMC" component={IMCScreen} />
        <Stack.Screen name="Divisas" component={DivisasScreen} />
        <Stack.Screen name="Propinas" component={PropinasScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

/* ================= Estilos ================= */
const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    padding: 20,
  },
  title: {
    fontSize: 22,
    marginBottom: 20,
    fontWeight: "bold",
  },
  input: {
    width: 200,
    height: 40,
    borderWidth: 1,
    borderColor: "gray",
    padding: 8,
    marginVertical: 10,
    borderRadius: 5,
    textAlign: "center",
  },
  result: {
    marginTop: 20,
    fontSize: 18,
    fontWeight: "600",
  },
});
