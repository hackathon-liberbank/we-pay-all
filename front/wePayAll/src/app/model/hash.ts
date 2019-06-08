export class Hash {
  constructor(
    public hash: string
  ) {}
}


export class Transactions {
  constructor(
    public debitor: string,
    public event: string,
    public ammount: number

  ) {}
}
