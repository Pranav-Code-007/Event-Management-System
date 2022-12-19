import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../Model/User';

@Pipe({
  name: 'userSearch'
})
export class UserSearchPipe implements PipeTransform {

  transform(value: User[], args: string): User[] {
    return value.filter(user => user.name.indexOf(args) !== -1);
  }

}
