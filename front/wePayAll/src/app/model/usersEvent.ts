export class UsersEvent {
  constructor(
    public users: Users[],
    public description: string,
    public iban: string,
    public name: string,
    public price: string

  ) {}
}

export class Users {
  constructor(
    public name: string,
    public surname: string
  ) {}
}
