// import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import Button from "./components/Button";

function App() {
  // const [name, setName] = useState("김수동");
  // const [count, setCount] = useState(0);
  // const changeName = () => {
  //   if (name === "김수동") setName("김정수");
  //   else setName("김수동");
  // };
  // let a = 1;
  // 버튼 + 을 누르면 count + 1
  // qjxms -을 누르면 count -1
  // const changeCount = (data) => {
  //   setCount((prev) => {
  //     a++;
  //     return prev + data;
  //   });
  // };
  // const [id, setId] = useState("");
  // const onChangeHandler = (e) => {
  //   setId(e.target.value);
  // };
  // const [state, setState] = useState({
  //   id: "",
  //   name1: "김수동",
  //   count1: 0,
  // });
  // const { id1, name1, count1 } = state;

  const [result, setResult] = useState(0);
  const [target, setTarget] = useState(0);

  const changeTarget = (e) => setTarget(Number(e.target.value));

  useEffect(() => {
    console.log({ result });
  }, [result]);

  const add = () => {
    setResult((prev) => {
      addLog(`${prev} + ${target} = ${prev + target}`);
      return prev + target;
    });
  };
  const diff = () => {
    setResult((prev) => {
      addLog(`${prev} - ${target} = ${prev - target}`);
      return prev + target;
    });
  };
  const mul = () => {
    setResult((prev) => {
      addLog(`${prev} * ${target} = ${prev * target}`);
      return prev + target;
    });
  };
  const div = () => {
    setResult((prev) => {
      addLog(`${prev} / ${target} = ${prev / target}`);
      return prev + target;
    });
  };

  const addLog = (log) => {
    setLogs((prev) => [...prev, log]);
  };

  const [logs, setLogs] = useState(["1 + 1 =2", "2 + 2 = 4"]);

  // const [num, setNum] = useState(0);
  // const [count, setCount] = useState(0);
  // const { id, count } = state;
  // const handleNumChange = (e) => {
  //   setNum(parseInt(e.target.value, 10));
  // };
  // const onChangeHandler = (operation) => {
  //   switch (operation) {
  //     case "+":
  //       setCount(count + num);
  //       break;
  //     case "-":
  //       setCount(count - num);
  //       break;
  //     case "*":
  //       setCount(count * num);
  //       break;
  //     case "/":
  //       setCount(count / num);
  //       break;
  //     default:
  //       break;
  //   }
  // };

  // const onChangeHandler1 = (name, value) => {
  //   setState((prev) => ({ ...prev, [name]: value }));
  // };
  const buttons = [
    { action: add, name: "+" },
    { action: diff, name: "-" },
    { action: mul, name: "*" },
    { action: div, name: "/" },
  ];
  const [oper, setOper] = useState("");

  return (
    <div className="App">
      <header className="App-header">
        <input type="number" onChange={changeTarget}></input>
        <select onChange={(e) => setOper(e.target.value)}>
          <option value={""}>선택해주세요</option>
          {buttons.map(({ name }) => (
            <option value={name}>{name}</option>
          ))}
        </select>

        {buttons.map((el) => (
          <Button el={el} />
        ))}
        <button onClick={() => addLog("2 + 2 = 4")}>test</button>
        <h1>{result}</h1>
        {logs
          .filter((el) => (oper === "" ? true : el.split(" ")[1] === oper))
          // .filter((el) => el.includes(`${oper}`))
          .map((el) => (
            <p>{el}</p>
          ))}
        {/* <button onClick={add}>+</button>
        <button onClick={diff}>-</button>
        <button onClick={mul}>*</button>
        <button onClick={div}>/</button> */}

        {/* <button onClick={() => onChangeHandler("+")}>+</button>
        <button onClick={() => onChangeHandler("-")}>-</button>
        <button onClick={() => onChangeHandler("*")}>*</button>
        <button onClick={() => onChangeHandler("/")}>/</button> */}
        {/* <img src={logo} className="App-logo" alt="logo" />
        <button onClick={changeName}>+</button>
        <br></br>
        <h2>{count}</h2>
        <button onClick={() => changeCount(1)}>+</button>
        <button onClick={() => changeCount(-1)}>-</button>
        <input name="id" value={id} onChange={onChangeHandler1}></input> */}
        {/* <img src={logo} className="App-logo" alt="logo" />
        <p>{name}</p>
        <button onClick={changeName}>+</button>
        <br></br>
        <h2>{count}</h2>
        <button onClick={() => changeCount(1)}>+</button>
        <button onClick={() => changeCount(-1)}>-</button>
        <input name="id" value={id} onChange={onChangeHandler1}></input> */}
      </header>
    </div>
  );
}
export default App;
