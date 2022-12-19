import { Pipe, PipeTransform } from '@angular/core';
import { Event } from '../Model/Event';

@Pipe({
  name: 'eventSearch'
})
export class EventSearchPipe implements PipeTransform {

  transform(value: Event[], args: string): Event[] {
    return value.filter(event => event.name.indexOf(args) !== -1);
  }

}
