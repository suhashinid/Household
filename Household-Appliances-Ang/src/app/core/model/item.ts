import {Deserializable} from "./deserializable";

export class Item implements Deserializable{

    id: number;
    serialNumber: string;
    brand: string;
    model: string;
    status: string;
    dateBought: Date;

     
  
    
    deserialize(input: any)
    {
        Object.assign(this, input);
        return this;
    }
    
}

// let items: Item[] = Object.assign(new Item(), {
//     id: 1,
//   serialNumber: "A123456",
//   brand: "Samsung",
//   model: "S20",
//   status: "New",
//   dateBought: new Date("01-06-2020")
//   });
let items_list = [{
    id: 1,
  serialNumber: "A123456",
  brand: "Samsung",
  model: "S20",
  status: "New",
  dateBought: new Date("01-06-2020")
  },
  {
    id: 2,
  serialNumber: "A123457",
  brand: "Samsung",
  model: "S10",
  status: "Old",
  dateBought: new Date("01-06-2018")
  },
  ];
  
  export const ITEMS: Item[]=Object.assign([],items_list);

