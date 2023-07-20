<?php

namespace app\Http\Controllers\Api;

use App\Models\Person;
use App\Http\Requests\StorePersonRequest;
use App\Http\Requests\UpdatePersonRequest;
use App\Models\User;
use Illuminate\Support\Facades\Request;
use Illuminate\Support\Facades\Validator;
use Spatie\FlareClient\Api;
use Tests\Helper;

class PersonController extends Api
{

    use Helper;
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StorePersonRequest $request)
    {
            $validasi=Validator::make($request->all(),[
            'users_id'=>'required',
            'fullname'=>'required',
            'birth'=>'required',
            'address'=>'required',
            'phone'=>'required',
            'sex'=>'required|in:F,M'
        ]);

        if ($validasi->fails()) {
            return $this->error_400($validasi->errors()->first());
        }
        $personal=Person::where('users_id',$request->users_id)->first();

        if ($personal) {
                $personal->update($request->all());
                return $this->valid_200("Berhasi; Update Data",$personal);
             return $this->error_400("Gagal Update");
        }else {
            $person=Person::create($request->all());

        if ($person) {
            return $this->valid_200('Berhasil Menambahkan data diri',$person);
            
        }else{
            return $this->error_400("Gagal menambahkan data");
        }
        }
        

      
    }

    /**
     * Display the specified resource.
     */
    public function show($id)
    {
        $person=Person::where('users_id',$id)->first();
        if ($person) {
            return $this->valid_200("Show data",$person);
        }else {
            return $this->error_400("Gagal");
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Person $person)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdatePersonRequest $request, Person $person)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Person $person)
    {
        //
    }
}
