<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Person extends Model
{
    use HasFactory;

    protected $table='people';
    protected $fillable = [
       'users_id',
       'fullname',
       'birth',
       'address',
       'phone',
       'sex'
   ];
}
